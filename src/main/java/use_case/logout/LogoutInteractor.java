package use_case.logout;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        userDataAccessObject = userDataAccessInterface;
        logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {
        LogoutOutputData logoutOutputData = new LogoutOutputData(userDataAccessObject.getCurrentUsername());
        userDataAccessObject.setCurrentUsername(null);
        logoutPresenter.prepareSuccessView(logoutOutputData);
    }
}

