/* 테스트 시작 페이지 이동 */
    @GetMapping("test/start/{testId}")
    public String testStart(@PathVariable("testId") Long testId, Model model) throws Exception {
        model.addAttribute("testId", testId);

        try {
            TestDTO testDTO = testService.findTestByTestId(testId);
            model.addAttribute("test", testDTO);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return "test/testStart";
    }
