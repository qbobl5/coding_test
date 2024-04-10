public interface TestService {
    /**
     * 테스트 아이디에 해당하는 테스트 정보를 조회한다.
     *
     * @param testId 테스트 아이디
     * @return 테스트 정보
     */
    TestDTO findTestByTestId(Long testId) throws Exception;
}
