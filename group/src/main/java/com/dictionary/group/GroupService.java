package com.dictionary.group;

import com.dictionary.amqp.RabbitMQMessageProducer;
import com.dictionary.clients.sentence.SentenceClient;
import com.dictionary.clients.word.WordClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
//    private final WordClient wordClient;
//    private final SentenceClient sentenceClient;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Integer id) {
        return groupRepository.findById(id).orElse(null);
    }

    public List<Group> getGroupsForDicByType(Integer dicId, String type) {
        return groupRepository.findByDicIdAndType(dicId, GroupType.valueOf(type));
    }
    // mogu i dvije metode jedna za dobavljanje grupe rjeci a druga grupe recenica

    public Group saveGroup(GroupDTO groupDTO) {
        Group group = Group.builder()
                .name(groupDTO.name())
                .description(groupDTO.description())
                .color(groupDTO.color())
                .type(groupDTO.type())
                .dicId(groupDTO.dicId())
                .build();

        return groupRepository.save(group);
    }

    public Group updateGroup(Integer id, GroupDTO groupDTO) {
        Group group = getGroupById(id);
        group.setName(groupDTO.name());
        group.setDescription(groupDTO.description());
        group.setColor(groupDTO.color());
        return groupRepository.save(group);
    }

    public void deleteGroup(Integer id, String type) {
        // kad se brise grupa trebalo bi obrisati sve rjeci ili recenice iz te grupe
        // moras provjeriti koji je tip grupe pa na osnovu toga brisati ili rjeci ili recenice za tu grupu
        if (type.equals("WGROUP"))
            rabbitMQMessageProducer.publish(id, "delete.wg", "del-wg.routing-key");
            // wordClient.deleteAllWordsForWg(id);
        else
            rabbitMQMessageProducer.publish(id, "delete.sg", "del-sg.routing-key");
            // sentenceClient.deleteAllSentencesForSg(id);

        groupRepository.deleteById(id);
    }

    @Transactional
    public Long deleteAllGroupsForDic(Integer dicId) {
        return groupRepository.removeByDicId(dicId);
    }
}
