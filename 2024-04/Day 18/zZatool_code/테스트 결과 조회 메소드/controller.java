/* 테스트 결과 조회 페이지 이동 */
    @GetMapping("result/{resultId}")
    public String myResult(@PathVariable("resultId") Long resultId, Model model) throws Exception {
        ResultDTO resultDTO = resultService.findResultByResultId(resultId);
        model.addAttribute("result", resultDTO);
        TestDTO testDTO = testService.findTestByTestId(resultDTO.getTestId());
        model.addAttribute("test", testDTO);
        return "test/testResult";
    }
