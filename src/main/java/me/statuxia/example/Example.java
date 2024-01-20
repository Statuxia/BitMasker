package me.statuxia.example;

final class Example {

    public static void main(String[] args) throws IllegalAccessException {
        TutorialState state = new TutorialState(false);
        System.out.printf("""
                        
                        join - %d
                        menu - %d
                        profile - %d
                        statistics - %d
                        settings - %d
                        
                        """,
                state.getJoin(), state.getMenu(), state.getProfile(),
                state.getStatistics(), state.getSettings()
        );
        System.out.println("current: " + state.getCurrent());
        state.addToCurrent(state.getJoin());
        System.out.println("new current: " + state.getCurrent());
        state.addToCurrent(state.getMenu());
        System.out.println("new current: " + state.getCurrent());
        state.addToCurrent(state.getMenu());
        System.out.println("new current: " + state.getCurrent());
    }
}
