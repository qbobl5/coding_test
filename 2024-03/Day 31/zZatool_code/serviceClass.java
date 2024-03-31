/* SELECT : 회원이 만든 테스트 목록 조회 */
@Override
public Page<MyTestDTO> findTestListByMemberId(Long memberId, String order, Pageable pageable)
        throws Exception {
    String[] orderArr = {"date", "count"};
    List<Test> testList = new ArrayList<>();
    if (order.equals(orderArr[0])) testList = orderByTestDate(memberId, pageable);
    else if (order.equals(orderArr[1])) testList = orderByTestCount(memberId, pageable);
    else throw new Exception("잘못된 접근입니다");
    if (testList.size() == 0) throw new Exception("테스트가 존재하지 않습니다");

    List<MyTestDTO> myTestDTOList = new ArrayList<>();
    for (Test test : testList) {
        myTestDTOList.add(myTestEntityToDTO(test));
    }

    Test exampleTest = Test.builder().memberId(memberId).build();
    ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();
    Example<Test> example = Example.of(exampleTest, exampleMatcher);
    Long cnt = testRepository.count(example);

    return new PageImpl<>(myTestDTOList, pageable, cnt);
}

/* method : 최신순으로 정렬된 테스트 목록 리턴 */
private List<Test> orderByTestDate(Long memberId, Pageable pageable) {
		try {
        return testRepository.findByMemberIdOrderByTestDateDesc(memberId, pageable);
    } catch (Exception e) {
        throw new Exception("테스트를 조회할 수 없습니다");
    }
}

/* method : 조회순으로 정렬된 테스트 목록 리턴 */
private List<Test> orderByTestCount(Long memberId, Pageable pageable) throws Exception {
    try {
        return testRepository.findByMemberIdOrderByTestCountDesc(memberId, pageable);
    } catch (Exception e) {
        throw new Exception("테스트를 조회할 수 없습니다");
    }
}

/* method : 테스트 entity를 dto로 변환 */
private MyTestDTO myTestEntityToDTO(Test test) {
    return MyTestDTO.builder()
            .testId(test.getTestId())
            .testTitle(test.getTestTitle())
            .testDate(test.getTestDate())
            .testCount(test.getTestCount())
            .build();
}
