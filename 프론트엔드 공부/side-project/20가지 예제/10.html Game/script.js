;(() => {
    ;('use strict')
  
    const get = (target) => document.querySelector(target)
  
    const $canvas = get('.canvas')
    const ctx = $canvas.getContext('2d')
  
    const $score = get('.score')
    const $highscore = get('.highscore')
    const $play = get('.js-play')
  
    const colorSet = {
      board: 'rgb(20, 105, 38)',
      snakeHead: 'rgba(229, 65, 120, 0.929)',
      snakeBody: 'rgba(153, 206, 244, 0.498)',
      food: 'rgb(66, 187, 103)',
    }
  
    let start = 0
    let option = {
      highScore: localStorage.getItem('score') || 0,
      gameEnd: true,
      direction: 2,
      snake: [
        { x: 10, y: 10, direction: 2 },
        { x: 10, y: 20, direction: 2 },
        { x: 10, y: 30, direction: 2 },
      ],
      food: { x: 0, y: 0 },
      score: 0,
    }
  
    const init = () => {
      document.addEventListener('keydown', (event) => {
        if (!/Arrow/gi.test(event.key)) {
          return
        }
        event.preventDefault()
        const direction = getDirection(event.key)
        if (!isDirectionCorrect(direction)) {
          return
        }
        option.direction = direction
      })
  
      $play.onclick = () => {
        if (option.gameEnd) {
          option = {
            highScore: localStorage.getItem('score') || 0,
            gameEnd: false,
            direction: 2,
            snake: [
              { x: 10, y: 10, direction: 2 },
              { x: 10, y: 20, direction: 2 },
              { x: 10, y: 30, direction: 2 },
            ],
            food: { x: 0, y: 0 },
            score: 0,
          }
          $score.innerHTML = `점수 : 0점`
          $highscore.innerHTML = `최고점수 : ${option.highScore}점`
          randomFood()
          window.requestAnimationFrame(play)
        }
      }
    }
  
    const buildBoard = () => {
      ctx.fillStyle = colorSet.board
      ctx.fillRect(0, 0, 300, 300)
    }
  
    const buildSnake = (ctx, x, y, head = false) => {
      ctx.fillStyle = head ? colorSet.snakeHead : colorSet.snakeBody
      ctx.fillRect(x, y, 10, 10)
    }
  
    const buildFood = (ctx, x, y) => {
      ctx.beginPath()
      ctx.fillStyle = colorSet.food
      ctx.arc(x + 5, y + 5, 5, 0, 2 * Math.PI)
      ctx.fill()
    }
  
    const setSnake = () => {
      for (let i = option.snake.length - 1; i >= 0; --i) {
        buildSnake(ctx, option.snake[i].x, option.snake[i].y, i === 0)
      }
    }
  
    const setHighScore = () => {
      const localScore = option.highScore * 1 || 0
      const finalScore = $score.textContent.match(/(\d+)/)[0] * 1
      if (localScore < finalScore) {
        alert(`최고기록 : ${finalScore}점`)
        localStorage.setItem('score', finalScore)
      }
    }
  
    const setDirection = (number, value) => {
      while (value < 0) {
        value += number
      }
      return value % number
    }
  
    const setBody = () => {
      const tail = option.snake[option.snake.length - 1]
      const direction = tail.direction
      let x = tail.x
      let y = tail.y
      switch (direction) {
        // down
        case 1:
          y = setDirection(300, y - 10)
          break
        // up
        case -1:
          y = setDirection(300, y + 10)
          break
        // left
        case -2:
          x = setDirection(300, x + 10)
          break
        // right
        case 2:
          x = setDirection(300, x - 10)
          break
      }
      option.snake.push({ x, y, direction })
    }
  
    const getFood = () => {
      const snakeX = option.snake[0].x
      const snakeY = option.snake[0].y
      const foodX = option.food.x
      const foodY = option.food.y
      if (snakeX == foodX && snakeY == foodY) {
        option.score++
        $score.innerHTML = `점수 : ${option.score}점`
        setBody()
        randomFood()
      }
    }
  
    const randomFood = () => {
      let x = Math.floor(Math.random() * 25) * 10
      let y = Math.floor(Math.random() * 25) * 10
      while (option.snake.some((part) => part.x === x && part.y === y)) {
        x = Math.floor(Math.random() * 25) * 10
        y = Math.floor(Math.random() * 25) * 10
      }
      option.food = { x, y }
    }
  
    const playSnake = () => {
      let x = option.snake[0].x
      let y = option.snake[0].y
      switch (option.direction) {
        // down
        case 1:
          y = setDirection(300, y + 10)
          break
        // up
        case -1:
          y = setDirection(300, y - 10)
          break
        // left
        case -2:
          x = setDirection(300, x - 10)
          break
        // right
        case 2:
          x = setDirection(300, x + 10)
          break
      }
      const snake = [{ x, y, direction: option.direction }]
      const snakeLength = option.snake.length
      for (let i = 1; i < snakeLength; ++i) {
        snake.push({ ...option.snake[i - 1] })
      }
      option.snake = snake
    }
  
    const getDirection = (key) => {
      let direction = 0
      switch (key) {
        case 'ArrowDown':
          direction = 1
          break
        case 'ArrowUp':
          direction = -1
          break
        case 'ArrowLeft':
          direction = -2
          break
        case 'ArrowRight':
          direction = 2
          break
      }
      return direction
    }
  
    const isDirectionCorrect = (direction) => {
      return (
        option.direction === option.snake[0].direction &&
        option.direction !== -direction
      )
    }
  
    const isGameOver = () => {
      const head = option.snake[0]
      return option.snake.some(
        (body, index) => index !== 0 && head.x === body.x && head.y === body.y
      )
    }
  
    const play = (timestamp) => {
      start++
      if (option.gameEnd) {
        return
      }
      if (timestamp - start > 1000 / 10) {
        if (isGameOver()) {
          option.gameEnd = true
          setHighScore()
          alert('게임오버!')
          return
        }
        playSnake()
        buildBoard()
        buildFood(ctx, option.food.x, option.food.y)
        setSnake()
        getFood()
        start = timestamp
      }
      window.requestAnimationFrame(play)
    }
  
    init()
  })()
  