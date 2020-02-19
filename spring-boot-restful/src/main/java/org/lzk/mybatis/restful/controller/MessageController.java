package org.lzk.mybatis.restful.controller;

import io.swagger.annotations.*;
import org.lzk.mybatis.restful.common.BaseResult;
import org.lzk.mybatis.restful.entity.Message;
import org.lzk.mybatis.restful.service.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: lzk
 * @version:
 * @date:2020/2/10 13:13
 * @description:
 */
@Api(value = "消息", description = "消息操作 API", position = 100, protocols = "http")
@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    // 获取所有消息体
    @ApiOperation(
            value = "消息列表",
            notes = "完整的消息内容列表",
            produces="application/json, application/xml",
            consumes="application/json, application/xml",
            response = List.class)
    @GetMapping(value = "messages")
    public List<Message> list() {
        List<Message> messages = this.messageRepository.findAll();
        return messages;
    }

    // 创建一个消息体
    @ApiOperation(value = "添加消息", notes = "根据参数创建消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "消息 ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "text", value = "正文", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "summary", value = "摘要", required = false, dataType = "String", paramType = "query"),
    })
    @PostMapping(value = "message")
    public Message create(Message message) {
        message = this.messageRepository.save(message);
        return message;
    }

    // 使用 put 请求进行修改
    @ApiOperation(value = "修改消息", notes = "根据参数修改消息")
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 103, message = "禁止访问"),
            @ApiResponse(code = 104, message = "请求路径不存在"),
            @ApiResponse(code = 200, message = "服务器内部错误")
    })
    @PutMapping(value = "message")
    public Message modify(Message message) {
        Message messageResult=this.messageRepository.update(message);
        return messageResult;
    }




    @PatchMapping(value="/message/text")
    public BaseResult<Message> patch(Message message) {
        Message messageResult=this.messageRepository.updateText(message);
        return BaseResult.successWithData(messageResult);
    }

    @GetMapping(value = "message/{id}")
    public Message get(@PathVariable Long id) {
        Message message = this.messageRepository.findMessage(id);
        return message;
    }

    @DeleteMapping(value = "message/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.messageRepository.deleteMessage(id);
    }
}
