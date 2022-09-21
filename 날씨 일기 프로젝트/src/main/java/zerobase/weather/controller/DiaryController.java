package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.net.URI;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.domain.Diary;
import zerobase.weather.dto.ResponseDiaryDto;
import zerobase.weather.service.DiarySerivce;

import java.time.LocalDate;

@RestController
public class DiaryController {
    private final DiarySerivce diarySerivce;

    public DiaryController(DiarySerivce diarySerivce) {
        this.diarySerivce = diarySerivce;
    }

    @ApiOperation(value = "일기 텍스트와 날씨를 이용해서 DB에 일기 저장", notes = "이것은 노트")
    @PostMapping("/create/Diary")
    public ResponseEntity<ResponseDiaryDto> createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     @ApiParam(value = "조회할 기간 날짜", example = "2022-02-02") LocalDate date,
                     @RequestBody @ApiParam(value = "일기 내용", example = "제로베이스 화이팅!") String text) throws Exception {
        ResponseDiaryDto responsee = diarySerivce.createDate(date, text);

        return ResponseEntity.created(URI.create("/create/Diary"))
            .body(responsee);
    }

    @ApiOperation(value = "선택한 날짜의 모든 일기 데이터를 가져옵니다.")
    @GetMapping("/read/diary")
    public ResponseEntity<List<ResponseDiaryDto>> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                          @ApiParam(value = "조회할 기간 날짜", example = "2022-02-02") LocalDate date) {
        List<ResponseDiaryDto> responseDiaryDtoList = diarySerivce.readDiary(date);
        return ResponseEntity.ok(responseDiaryDtoList);
    }

    @ApiOperation(value = "선택한 기간중의 모든 일기 데이터를 기록합니다.")
    @GetMapping("/read/diaries")
    public  ResponseEntity<List<ResponseDiaryDto>> readDiaries(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                            @ApiParam(value = "조회할 기간의 시작 날짜", example = "2022-02-02") LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                            @ApiParam(value = "조회할 기간의 마지막 날짜", example = "2022-02-02") LocalDate endDate) {
        List<ResponseDiaryDto> responseDiaryDtoList = diarySerivce.readDiaries(startDate, endDate);
        return ResponseEntity.ok(responseDiaryDtoList);
    }

    @ApiOperation(value = "선택한 날짜의 일기 내용을 수정합니다.")
    @PutMapping("/update/diary")
    public ResponseEntity<ResponseDiaryDto> updateDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     @ApiParam(value = "조회할 기간 날짜", example = "2022-02-02") LocalDate date,
                     @RequestBody @ApiParam(value = "수정 될 일기 내용", example = "제로베이스 화이팅!") String text) {
        ResponseDiaryDto response = diarySerivce.updateDiary(date, text);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "선택한 날짜의 일기를 삭제합니다.")
    @DeleteMapping("/delete/diary")
    public ResponseEntity<Void> deleteDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     @ApiParam(value = "조회할 기간 날짜", example = "2022-02-02") LocalDate date) {
        diarySerivce.deleteDiary(date);
        return ResponseEntity.ok().build();
    }

}
