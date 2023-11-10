/*
 * Controller.ControllerFactory
 * Create by Bin
 * Date 11/10/23, 8:53 PM
 * Description:
 */

package Controller;
import Enum.*;
import View.*;

import javax.swing.*;



public class ControllerFactory{
    private ControllerFactory() {
    }
    public static Action getView(ViewType viewType,JPanel panel) {
        JPanel currentView = ViewFactory.getView(viewType);
        return switch (viewType) {
            case HOME -> null;
            case SEARCH_SLANG -> new SearchSlangController((SearchSlangView) currentView);
            case SEARCH_DEFINITION -> new SearchDefinitionController((SearchDefinitionView) currentView);
            case HISTORY -> new HistoryController((HistoryPageView) currentView);
            case ADD -> new AddSlangController((AddSlangView) currentView);
            case EDIT -> new EditSlangController((EditSlangView) currentView);
            case DELETE -> new DeleteSlangController((DeleteSlangView) currentView);
            case RESET -> new ResetSlangController((ResetSlangView) currentView);
            case RANDOM -> new RandomSlangController((RandomSlangView) currentView);
            case QUIZ_SLANG -> new QuizSlangController((QuizSlangView) currentView);
            case QUIZ_DEFINITION -> new QuizDefinitionController((QuizDefinitionView) currentView);
        };
    }
}
