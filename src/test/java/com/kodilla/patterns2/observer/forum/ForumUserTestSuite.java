package com.kodilla.patterns2.observer.forum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {
    @Test
    public void testUpdate() {
        //Given
        final ForumTopic javaHelpGroup = new JavaHelpForumTopic();
        final ForumTopic javaToolsGroup = new JavaToolsForumTopic();
        final ForumUser johnSmith = new ForumUser("John Smith");
        final ForumUser ivoneExcobar = new ForumUser("Ivone Excobar");
        final ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");
        javaHelpGroup.registerObserver(johnSmith);
        javaToolsGroup.registerObserver(ivoneExcobar);
        javaHelpGroup.registerObserver(jessiePinkman);
        javaToolsGroup.registerObserver(jessiePinkman);
        //When
        javaHelpGroup.addPost("Hi");
        javaHelpGroup.addPost("How are You?");
        javaHelpGroup.addPost("Fine thx");
        javaToolsGroup.addPost("Why");
        javaToolsGroup.addPost("because yes");
        //Then
        assertEquals(3, johnSmith.getUpdateCount());
        assertEquals(2, ivoneExcobar.getUpdateCount());
        assertEquals(5, jessiePinkman.getUpdateCount());
    }


}