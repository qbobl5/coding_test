@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;
    private final MemberRepository memberRepository;

    /* SELECT : 테스트 정보 조회 */
    @Override
    public TestDTO findTestByTestId(Long testId) throws Exception {
        Optional<Test> testOpt = testRepository.findById(testId);
        if (!testOpt.isPresent()) {
            throw new Exception("테스트가 존재하지 않습니다");
        }

        Test test = testOpt.get();
        if (test.getTestStatus() == 0) {
            throw new Exception("테스트가 존재하지 않습니다");
        }

        List<HashtagDTO> hashtagDTOList = new ArrayList<>();
        for (TestHashtag hashtag : test.getHashtagList()) {
            HashtagDTO hashtagDTO =
                    HashtagDTO.builder()
                            .testHashtagId(hashtag.getTestHashtagId())
                            .tagContent(hashtag.getTagContent())
                            .build();
            hashtagDTOList.add(hashtagDTO);
        }

        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (Comment comment : test.getCommentList()) {
            CommentDTO commentDTO =
                    CommentDTO.builder()
                            .commentId(comment.getCommentId())
                            .commentWriter(comment.getCommentWriter())
                            .commentContent(comment.getCommentContent())
                            .commentDate(comment.getCommentDate())
                            .build();
            commentDTOList.add(commentDTO);
        }

        String memberName = findNicknameByMemberId(test.getMemberId());
        return testEntityToDTO(test, hashtagDTOList, commentDTOList, memberName);
    }

    /* method : 회원 아이디로 회원 닉네임 조회 */
    private String findNicknameByMemberId(Long memberId) throws Exception {
        try {
            return memberRepository.findById(memberId).get().getNickname();
        } catch (Exception e) {
            throw new Exception("테스트가 존재하지 않습니다");
        }
    }

    /* method : 테스트 entity를 dto로 변환 */
    private TestDTO testEntityToDTO(
            Test test,
            List<HashtagDTO> hashtagList,
            List<CommentDTO> commentList,
            String memberName) {
        return TestDTO.builder()
                .testId(test.getTestId())
                .testTitle(test.getTestTitle())
                .memberName(memberName)
                .testImage(test.getTestImage())
                .testCount(test.getTestCount())
                .testDate(test.getTestDate())
                .hashtagList(hashtagList)
                .commentList(commentList)
                .build();
    }
}
