package ch.zli.hose_abe_jass_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.hose_abe_jass_backend.exception.JoinRoomException;
import ch.zli.hose_abe_jass_backend.model.Room;
import ch.zli.hose_abe_jass_backend.model.RoomService;

@CrossOrigin(origins = "*")
@RestController
public class GameController {

  @Autowired
  private RoomService roomService;

  // TODO: rest functions for this

  @PostMapping("/room/{name}/{roomCode}")
  public Object joinRoom(@PathVariable String name, @PathVariable String roomCode) {
    try {
      return roomService.joinRoom(name, roomCode);
    } catch (JoinRoomException ex) {
      return "{ \"error\": \"" + ex.getErrorMessage() + "\"}";
    }
  }

  @PostMapping("/room/{username}")
  public Room createRoom(@PathVariable String username) {
    return roomService.createRoom(username);
  }

  @PostMapping("/room/start/{roomCode}")
  public Room startGame(@PathVariable String roomCode) {
    return roomService.startGame(roomCode);
  }
}
