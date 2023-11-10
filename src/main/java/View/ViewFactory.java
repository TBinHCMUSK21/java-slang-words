/*
 * View.ViewFactory
 * Create by Bin
 * Date 11/10/23, 9:40 AM
 * Description:
 */

package View;
import Enum.*;

import javax.swing.*;



public class ViewFactory{
        private ViewFactory() {
        }
        public static JPanel getView(ViewType viewType) {
            return switch (viewType) {
                case HOME -> new HomePageView();
                case ADD -> new AddSlangView();
                case DELETE -> new DeleteSlangView();
                case EDIT -> new EditSlangView();
                case HISTORY -> new HistoryPageView();
                case QUIZ_DEFINITION -> new QuizDefinitionView();
                case QUIZ_SLANG -> new QuizSlangView();
                case RANDOM -> new RandomSlangView();
                case RESET -> new ResetSlangView();
                case SEARCH_DEFINITION -> new SearchDefinitionView();
                case SEARCH_SLANG -> new SearchSlangView();
            };
        }
}
