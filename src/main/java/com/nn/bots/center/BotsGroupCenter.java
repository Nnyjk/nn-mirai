package com.nn.bots.center;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.event.events.GroupMessageEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangxiao
 * @since V1.0.0 2024/07/15
 */
@Singleton
public class BotsGroupCenter {
    @Inject
    BotsCenter botsCenter;


    public List<Group> groups(Long id) {
        Bot bot = botsCenter.bot(id);
        return new ArrayList<>(bot.getGroups());
    }

    public Group group(Long id, Long groupId) {
        Bot bot = botsCenter.bot(id);
        Group group = bot.getGroup(groupId);
        if (null == group) {
            throw new IllegalArgumentException("can't find group by id: " + groupId);
        }
        return group;
    }

    public void attach(Long id, Long groupId) {
        Bot bot = botsCenter.bot(id);
        Group group = group(id, groupId);
        group.sendMessage("咩小🐏已被成功唤醒。");
        bot.getEventChannel().subscribeAlways(GroupMessageEvent.class, event -> {
            if (!groupId.equals(event.getGroup().getId())) {
                return;
            }
            if (!"咩".equals(event.getMessage().contentToString())) {
                return;
            }
            event.getSubject().sendMessage("咩");
        });
    }
}
