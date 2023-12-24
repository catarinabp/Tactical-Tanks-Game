package org.example.controller.game;

import org.example.GUI.GUI;
import org.example.model.Position;
import org.example.model.game.elements.*;
import org.example.model.game.map.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class ShootControllerTest {

    @Mock
    private Map mockMap;

    @Mock
    private PlayerTank mockPlayerTank;

    @Mock
    private NPCs mockNPC;

    @Mock
    private Box mockBox;

    private ShootController shootController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockMap.getPlayerTank()).thenReturn(mockPlayerTank);
        when(mockMap.isNPC(any(Position.class))).thenReturn(false);
        when(mockMap.getNPCs()).thenReturn(List.of(mockNPC));
        when(mockMap.isBox(any(Position.class))).thenReturn(false);
        when(mockMap.getBoxes()).thenReturn(List.of(mockBox));

        // Simular o retorno de um objeto Shoot válido
        when(mockMap.getShoot()).thenReturn(mock(Shoot.class));

        shootController = new ShootController(mockMap);
    }

    @Test
    public void testMoveBulletHitNPC() {
        Position initialPosition = new Position(1, 1);
        when(mockPlayerTank.getPosition()).thenReturn(initialPosition);
        when(mockMap.canShoot(any(Position.class))).thenReturn(true);
        when(mockMap.isNPC(any(Position.class))).thenReturn(true);
        when(mockNPC.getPosition()).thenReturn(initialPosition);

        shootController.moveBullet(GUI.ACTION.UP);


        verify(mockMap, times(1)).removeNPC(mockNPC);
        verify(mockMap, times(1)).setShoot(null);
    }

    @Test
    public void testMoveBulletHitBox() {
        // Configurar o estado do mock para simular a bala não atingindo nada
        Position initialPosition = new Position(1, 1);
        when(mockMap.getPlayerTank().getPosition()).thenReturn(initialPosition);
        when(mockMap.canShoot(any(Position.class))).thenReturn(true);
        when(mockMap.isNPC(any(Position.class))).thenReturn(false);
        when(mockMap.isBox(any(Position.class))).thenReturn(true);

        // Chamar o método a ser testado
        shootController.moveBullet(GUI.ACTION.UP);

        // Verificar se a bala não atingiu nada
        verify(mockMap, times(0)).removeNPC(any(NPCs.class));
        verify(mockMap, times(1)).removeBox(any(Box.class));
        verify(mockMap, times(0)).setShoot(null);
    }

    // Add more tests as needed for other scenarios



    @Test
    public void tesMoveBulletMissed() {
        // Configurar o estado do mock para simular a bala não atingindo nada
        Position initialPosition = new Position(1, 1);
        when(mockMap.getPlayerTank().getPosition()).thenReturn(initialPosition);
        when(mockMap.canShoot(any(Position.class))).thenReturn(true);
        when(mockMap.isNPC(any(Position.class))).thenReturn(false);
        when(mockMap.isBox(any(Position.class))).thenReturn(false);

        // Chamar o método a ser testado
        shootController.moveBullet(GUI.ACTION.UP);

        // Verificar se a bala não atingiu nada
        verify(mockMap, times(0)).removeNPC(any(NPCs.class));
        verify(mockMap, times(0)).removeBox(any(Box.class));
        verify(mockMap, times(0)).setShoot(null);
    }

    // Adicione outros métodos de teste conforme necessário
}


