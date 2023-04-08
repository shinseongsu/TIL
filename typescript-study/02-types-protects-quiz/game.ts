{
  const position = { x: 0, y: 0 };

  console.log(position);
  move("up");
  console.log(position);
  move("down");
  console.log(position);
  move("left");
  console.log(position);
  move("right");
  console.log(position);

  type Direction = "up" | "down" | "left" | "right";

  function move(direction: Direction) {
    switch (direction) {
      case "up":
        position.y++;
        break;
      case "down":
        position.y--;
        break;
      case "left":
        position.x--;
        break;
      case "right":
        position.x++;
        break;
      default:
        const invalid: never = direction;
        throw new Error(`unknown direction: ${invalid}`);
    }
  }
}
