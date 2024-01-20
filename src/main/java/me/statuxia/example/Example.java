package me.statuxia.example;

final class Example {

    public static void main(String[] args) throws IllegalAccessException {
        example1();
        example2();
        example3();
        example4();
    }

    private static void example1() throws IllegalAccessException {
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

    private static void example2() throws IllegalAccessException {
        TutorialState state = new TutorialState();
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

    private static void example3() throws IllegalAccessException {
        TutorialState state = new TutorialState(2);
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

    private static void example4() throws IllegalAccessException {
        TutorialState state = new TutorialState(2, false);
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
