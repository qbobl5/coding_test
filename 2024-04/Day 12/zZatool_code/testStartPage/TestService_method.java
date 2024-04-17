/* method : 문제 목록 entity를 dto로 변환 */
    private List<QuizDTO> findQuizList(Test test) throws Exception {
        List<QuizDTO> quizDTOList = new ArrayList<>();

        if (test.getQuizList().size() == 0) throw new Exception("문제가 존재하지 않습니다");
        for (Quiz quiz : test.getQuizList()) {
            List<ViewDTO> viewDTOList = new ArrayList<>();
            for (View view : quiz.getViewList()) {
                ViewDTO viewDTO =
                        ViewDTO.builder()
                                .viewId(view.getViewId())
                                .viewNumber(view.getViewNumber())
                                .viewContent(view.getViewContent())
                                .build();
                viewDTOList.add(viewDTO);
            }

            viewDTOList.sort(
                    new Comparator<ViewDTO>() {
                        @Override
                        public int compare(ViewDTO v1, ViewDTO v2) {
                            return v1.viewNumber() - v2.viewNumber();
                        }
                    });

            QuizDTO quizDTO =
                    QuizDTO.builder()
                            .quizId(quiz.getQuizId())
                            .quizNo(quiz.getQuizNo())
                            .quizContent(quiz.getQuizContent())
                            .quizImage(quiz.getQuizImage())
                            .viewList(viewDTOList)
                            .build();
            quizDTOList.add(quizDTO);
        }

        quizDTOList.sort(
                new Comparator<QuizDTO>() {
                    @Override
                    public int compare(QuizDTO q1, QuizDTO q2) {
                        return q1.quizNo() - q2.quizNo();
                    }
                });

        return quizDTOList;
    }
