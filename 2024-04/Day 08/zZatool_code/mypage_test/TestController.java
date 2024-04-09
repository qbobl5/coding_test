package com.timekiller.zzatool.test.control;

import com.timekiller.zzatool.exception.RemoveException;
import com.timekiller.zzatool.test.dto.MyTestDTO;
import com.timekiller.zzatool.test.dto.TestCreateDTO;
import com.timekiller.zzatool.test.dto.TestDTO;
import com.timekiller.zzatool.test.service.TestService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {
    private static final int MY_TEST_CONTENT_SIZE = 9;
    private static final int PAGE_SIZE = 5;
    private final TestService testService;
    private int totalPage;
    private long totalTestCount;

    /* 내가 만든 테스트 조회 페이지 이동 */
    @GetMapping("/mypage/{memberId}/test/{order}/{page}")
    public String mytestList(
            @PathVariable("memberId") Long memberId,
            @PathVariable("order") String order,
            @PathVariable("page") Integer page,
            Model model)
            throws Exception {
        Pageable pageable = PageRequest.of(page - 1, 9);

        try {
            Page<MyTestDTO> testList =
                    testService.findTestListByMemberId(memberId, order, pageable);
            this.totalPage = testList.getTotalPages();
            this.totalTestCount = testList.getTotalElements();
            model.addAttribute("tests", testList.getContent());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        model.addAttribute("link", "/mypage");
        model.addAttribute("memberId", memberId);
        model.addAttribute("order", order);
        model.addAttribute("page", page);
        model.addAttribute("startPage", 1);
        model.addAttribute("isFirstPage", true);

        int endPage = 5;
        if (PAGE_SIZE * MY_TEST_CONTENT_SIZE >= totalTestCount) {
            endPage = (int) Math.ceil((double) totalTestCount / MY_TEST_CONTENT_SIZE);
        }
        model.addAttribute("endPage", endPage);
        boolean isLastPage = endPage == 1;
        model.addAttribute("isLastPage", isLastPage);

        return "member/myTest";
    }
}
