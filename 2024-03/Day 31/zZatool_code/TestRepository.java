/**
  * memberId에 해당하는 테스트 목록을 testDate desc로 정렬하여 pageable만큼 조회
  *
  * @param memberId 회원 아이디
  * @param pageable 페이지
  * @return 테스트 목록
  */
List<Test> findByMemberIdOrderByTestDateDesc(Long memberId, Pageable pageable);

/**
  * memberId에 해당하는 테스트 목록을 testCount desc로 정렬하여 pageable만큼 조회
  *
  * @param memberId 회원 아이디
  * @param pageable 페이지
  * @return 테스트 목록
  * @throws Exception sqlException 또는 정렬 기준 오류
  */
List<Test> findByMemberIdOrderByTestCountDesc(Long memberId, Pageable pageable);
