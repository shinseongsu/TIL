;(function () {
    'use strict'
  
    const get = (target) => {
      return document.querySelector(target)
    }
  
    const carousel = get('.carousel')
    const cellCount = 6
    let selectedIndex = 0
  
    const rotateCarousel = () => {
      const angle = (selectedIndex / cellCount) * -360
      carousel.style.transform = 'translateZ(-346px) rotateY(' + angle + 'deg)'
    }
  
    const prevButton = get('.prev_button')
    prevButton.addEventListener('click', () => {
      selectedIndex--
      rotateCarousel()
    })
  
    const nextButton = get('.next_button')
    nextButton.addEventListener('click', () => {
      selectedIndex++
      rotateCarousel()
    })
  })()
  