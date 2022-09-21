package com.example.stomp.controller;

import com.example.stomp.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Log4j2
public class RoomController {

    private final ChatRoomRepository chatRoomRepository;

    @GetMapping(value = "/rooms")
    public ModelAndView rooms() {
        log.info("# All chat Rooms");

        ModelAndView mav = new ModelAndView("chat/rooms");
        mav.addObject("list", chatRoomRepository.findAllRomms());

        return mav;
    }

    @PostMapping(value = "/room")
    public String create(@RequestParam String name, RedirectAttributes redirectAttributes) {
        log.info("# Create Chat Room, name " + name);
        redirectAttributes.addFlashAttribute("roomName", chatRoomRepository.createChatRoom(name));
        return "redirect:/chat/rooms";
    }

    @GetMapping("/room")
    public void getRoom(String roomId, Model model) {
        log.info("# get Chat Room, roomID : " + roomId);

        model.addAttribute("room", chatRoomRepository.findByRoomById(roomId));
    }


}
