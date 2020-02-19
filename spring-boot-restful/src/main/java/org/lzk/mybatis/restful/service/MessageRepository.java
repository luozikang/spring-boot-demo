package org.lzk.mybatis.restful.service;

import org.lzk.mybatis.restful.entity.Message;

import java.util.List;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/10 13:16
 * @description:
 */
public interface MessageRepository {
    List<Message> findAll();

    Message save(Message message);

    Message update(Message message);

    Message updateText(Message message);

    Message findMessage(Long id);

    void deleteMessage(Long id);
}
