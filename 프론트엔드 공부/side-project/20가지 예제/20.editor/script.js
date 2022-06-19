;(function () {
    'use strict'
  
    const commands = [
      {
        cmd: 'backColor',
        val: 'red',
        label: '배경 컬러',
      },
      {
        cmd: 'bold',
        label: '굵기',
      },
      {
        cmd: 'delete',
        label: '삭제',
      },
      {
        cmd: 'fontSize',
        label: '폰트 사이즈',
        val: '1-7',
      },
      {
        cmd: 'foreColor',
        label: '폰트 컬러',
        val: 'rgba(0,0,0,.5)',
      },
      {
        cmd: 'insertImage',
        label: '이미지 추가',
        val: 'http://dummyimage.com/160x90',
      },
      {
        cmd: 'italic',
        label: '기울이기',
      },
      {
        cmd: 'justifyCenter',
        label: '중앙 정렬',
      },
      {
        cmd: 'justifyFull',
        label: '양쪽 정렬',
      },
      {
        cmd: 'justifyLeft',
        label: '좌측 정렬',
      },
      {
        cmd: 'justifyRight',
        label: '우측 정렬',
      },
  
      {
        cmd: 'selectAll',
        label: '전체 선택',
      },
      {
        cmd: 'underline',
        label: '밑줄',
      },
      {
        cmd: 'undo',
        label: '취소',
      },
    ]
  
    let commandObject = {}
  
    const doCommand = (cmdKey) => {
      const cmd = commandObject[cmdKey]
  
      const val =
        typeof cmd.val !== 'undefined'
          ? prompt('Value for ' + cmd.cmd + '?', cmd.val)
          : ''
      document.execCommand(cmd.cmd, false, val || '')
    }
  
    const onClickShowEditorButton = () => {
      editorEdit.innerHTML = editorHtml.innerText
      editorEdit.classList.toggle('show')
      editorHtml.classList.toggle('show')
    }
    const onClickShowHTMLButton = () => {
      editorHtml.innerText = editorEdit.innerHTML
      editorEdit.classList.toggle('show')
      editorHtml.classList.toggle('show')
    }
  
    const get = (target) => {
      return document.querySelector(target)
    }
  
    const editorEdit = get('.editor.edit')
    const editorHtml = get('.editor.html')
    const editorButtons = get('.editor_buttons')
    const showEditorButton = get('.show_editor_button')
    const showHTMLButton = get('.show_html_button')
  
    const init = () => {
      commands.map((command) => {
        commandObject[command.cmd] = command
        const element = document.createElement('button')
        element.innerText = command.label
        element.addEventListener('click', (e) => {
          e.preventDefault()
          doCommand(command.cmd)
        })
        editorButtons.appendChild(element)
      })
    }
  
    showEditorButton.addEventListener('click', onClickShowEditorButton)
    showHTMLButton.addEventListener('click', onClickShowHTMLButton)
  
    init()
  })()
  