package hac;

/**
 * Struct that save answer and count of votes  on same  answer
 */
public @interface PairOfAnswerCount
{
    class AnswerAndCount
    {
        private Integer count;
        private String answer;
        /**
         *  ctor of AnswerAndCount
         * @param answer member that save answers
         * @param count member that save count client voted
         */
        AnswerAndCount(String answer, Integer count)
        {
            this.answer = answer;
            this.count = count;
        }

        /**
         * function that get count member
         * @return count client voted
         */
        public Integer getCount() {
            return count;
        }

        /**
         * function that set count member
         * @param count- save of  client voted
         *
         */
        public void setCount(Integer count) {
            this.count = count;
        }

        /**
         *  function that get ans member
         * @return answer - member that save answers
         */
        public String getAnswer() {
            return answer;
        }
    }
}
