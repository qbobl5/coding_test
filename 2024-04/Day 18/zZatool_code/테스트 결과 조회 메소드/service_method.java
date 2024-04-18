/* SELECT : 결과 상세 조회 */
    @Override
    public ResultDTO findResultByResultId(Long resultId) throws Exception {
        Optional<Result> resultOpt = resultRepository.findById(resultId);
        if (!resultOpt.isPresent()) {
            throw new Exception("결과가 존재하지 않습니다");
        }

        Result result = resultOpt.get();
        List<ResultViewDTO> resultViewDTOList = findResultViewList(result.getResultViewList());
        ResultDTO resultDTO =
                ResultDTO.builder()
                        .resultId(result.getResultId())
                        .testId(result.getTestId())
                        .resultScore(result.getResultScore())
                        .resultViewList(resultViewDTOList)
                        .build();
        return resultDTO;
    }

/* method : resultView 목록 생성하기 */
    private List<ResultViewDTO> findResultViewList(List<ResultView> resultViewList)
            throws Exception {
        List<ResultViewDTO> resultViewDTOList = new ArrayList<>();
        for (ResultView resultView : resultViewList) {
            ResultViewDTO resultViewDTO =
                    ResultViewDTO.builder()
                            .quiz(findQuizByViewId(resultView.getCorrectAnswer().getViewId()))
                            .myNo(resultView.getMyNo())
                            .myAnswer(resultView.getMyAnswer())
                            .correctNo(resultView.getCorrectAnswer().getViewNumber())
                            .correctAnswer(resultView.getCorrectAnswer().getViewContent())
                            .build();
            resultViewDTOList.add(resultViewDTO);
        }
        return resultViewDTOList;
    }

/* method : viewId에 해당하는 quiz 리턴 */
    private QuizDTO findQuizByViewId(Long viewId) throws Exception {
        Optional<View> viewOpt = viewRepository.findById(viewId);
        if (!viewOpt.isPresent()) {
            throw new Exception("보기가 존재하지 않습니다");
        }

        View view = viewOpt.get();

        Optional<Quiz> quizOpt = quizRepository.findById(view.getQuizId());
        if (!quizOpt.isPresent()) {
            throw new Exception("문제가 존재하지 않습니다");
        }

        Quiz quiz = quizOpt.get();
        QuizDTO quizDTO =
                QuizDTO.builder()
                        .quizNo(quiz.getQuizNo())
                        .quizImage(quiz.getQuizImage())
                        .quizContent(quiz.getQuizContent())
                        .build();

        return quizDTO;
    }
