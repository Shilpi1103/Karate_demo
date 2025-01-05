package example.DemoApi;

import com.intuit.karate.junit5.Karate;

 class TestRunner {
    @Karate.Test
     Karate airline() {
         return Karate.run("CreateAirline").relativeTo(getClass());
     }
}

