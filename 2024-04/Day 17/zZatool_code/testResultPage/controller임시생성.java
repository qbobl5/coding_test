/* 테스트 결과 조회 페이지 이동 */
@GetMapping("result/{resultId}")
public String myResult(@PathVariable("resultId") Long resultId, Model model) {
    return "test/testResult";
}
