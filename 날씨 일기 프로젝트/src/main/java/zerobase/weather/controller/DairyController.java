package zerobase.weather.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.service.DiarySerivce;

import java.time.LocalDate;

@RestController
public class DairyController {
    private final DiarySerivce diarySerivce;

    public DairyController(DiarySerivce diarySerivce) {
        this.diarySerivce = diarySerivce;
    }

    @PostMapping("/create/Diary")
    void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                     @RequestBody String text) {
        diarySerivce.createDate(date, text);
    }
}
