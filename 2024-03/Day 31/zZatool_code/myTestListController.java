@GetMapping("/test/{memberId}/{order}/{page}")
public Page<MyTestDTO> myTestList(
        @PathVariable("memberId") Long memberId,
        @PathVariable("order") String order,
        @PathVariable("page") Integer page)
        throws Exception {
    try {
        Pageable pageable = PageRequest.of(page - 1, 20);
        return testService.findTestListByMemberId(memberId, order, pageable);
    } catch (Exception e) {
        throw new Exception(e.getMessage());
    }
}
