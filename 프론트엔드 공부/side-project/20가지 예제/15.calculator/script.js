;(function () {
    'use strict'
  
    const get = (target) => {
      return document.querySelector(target)
    }
  
    const getAll = (target) => {
      return document.querySelectorAll(target)
    }
  
    class Calculator {
      constructor(element) {
        this.element = element
        this.currentValue = ''
        this.prevValue = ''
        this.operation = null
      }
  
      reset() {
        this.currentValue = ''
        this.prevValue = ''
        this.resetOperation()
      }
  
      clear() {
        if (this.currentValue) {
          this.currentValue = ''
          return
        }
        if (this.operation) {
          this.resetOperation()
          this.currentValue = this.prevValue
          return
        }
        if (this.prevValue) {
          this.prevValue = ''
          return
        }
      }
  
      appendNumber(number) {
        if (number === '.' && this.currentValue.includes('.')) return
        this.currentValue = this.currentValue.toString() + number.toString()
      }
  
      setOpertaion(operation) {
        this.resetOperation()
        this.operation = operation
        this.prevValue = this.currentValue
        this.currentValue = ''
  
        const elements = Array.from(getAll('.operation'))
        const element = elements.filter((element) =>
          element.innerText.includes(operation)
        )[0]
        element.classList.add('active')
      }
  
      compute() {
        let computation
        const prev = parseFloat(this.prevValue)
        const current = parseFloat(this.currentValue)
        if (isNaN(prev) || isNaN(current)) return
        switch (this.operation) {
          case '+':
            computation = prev + current
            break
          case '-':
            computation = prev - current
            break
          case '*':
            computation = prev * current
            break
          case '÷':
            computation = prev / current
            break
          default:
            return
        }
        this.currentValue = computation.toString()
        this.prevValue = ''
        this.resetOperation()
      }
  
      updateDisplay() {
        if (this.currentValue) {
          this.element.value = this.currentValue
          return
        }
        if (this.prevValue) {
          this.element.value = this.prevValue
          return
        }
        this.element.value = 0
      }
  
      resetOperation() {
        this.operation = null
        const elements = Array.from(getAll('.operation'))
        elements.forEach((element) => {
          element.classList.remove('active')
        })
      }
    }
  
    const numberButtons = getAll('.cell_button.number')
    const operationButtons = getAll('.cell_button.operation')
    const allClearButton = get('.cell_button.all_clear')
    const clearButton = get('.cell_button.clear')
    const computeButton = get('.cell_button.compute')
    const display = get('.display')
  
    const calculator = new Calculator(display)
  
    numberButtons.forEach((button) => {
      button.addEventListener('click', () => {
        calculator.appendNumber(button.innerText)
        calculator.updateDisplay()
      })
    })
  
    operationButtons.forEach((button) => {
      button.addEventListener('click', () => {
        calculator.setOpertaion(button.innerText)
        calculator.updateDisplay()
      })
    })
  
    computeButton.addEventListener('click', () => {
      calculator.compute()
      calculator.updateDisplay()
    })
  
    clearButton.addEventListener('click', () => {
      calculator.clear()
      calculator.updateDisplay()
    })
    allClearButton.addEventListener('click', () => {
      calculator.reset()
      calculator.updateDisplay()
    })
  })()
  