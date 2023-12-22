package org.example.controllers;

import org.example.GUI.GUI;
import org.example.controller.game.ShootController;
import org.example.model.Position;
import org.example.model.game.elements.Box;
import org.example.model.game.elements.NPCs;
import org.example.model.game.elements.PlayerTank;
import org.example.model.game.elements.Shoot;
import org.example.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ShootControllerTest {

    @Mock
    private Map mockMap;

    private ShootController shootController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        shootController = new ShootController(mockMap);
    }


}
