package com.webcheckers.appl;

import com.webcheckers.model.Game;
import com.webcheckers.model.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;
import spark.Session;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameCenterTest {
    Session session;
    Request request;
    Response response;
    Player playerRed;
    Player playerWhite;
    Game game;
    String GAME_ID;

    @Before
    public void setUp() throws Exception {
         session = mock(Session.class);
         request = mock(Request.class);
         response = mock(Response.class);
        playerRed = mock(Player.class);
        playerWhite=mock(Player.class);
        //game=mock(Game.class);
        GAME_ID="game";
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void get() throws Exception {

        assertNotNull(session);
        assertNotNull(playerRed);
        assertNotNull(playerWhite);
        when(session.attribute(GAME_ID)).thenReturn(game);
        assertNull(session.attribute(GAME_ID));
        assertTrue(session.attribute(GAME_ID)==null);
        game=new Game(playerRed,playerWhite);
        assertNotNull(game);
    }

    @Test
    public void end() throws Exception {

        assertNotNull(session);
        session.removeAttribute(GAME_ID);
        assertNull(game);
    }

}