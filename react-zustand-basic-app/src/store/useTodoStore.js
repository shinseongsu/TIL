import create from 'zustand';

export const useTodoStore = create((set) => ({
    todos: [],
    addTodo: (todoText) =>
        set(state => ({
            todos: [
                ...state.todos,
                {
                    text: todoText,
                    id: getId(),
                    isCompleted: false
                }
            ]
        })),
    deleteTodo: (todoId) =>
        set(state => ({
            todos: state.todos.filter(todo => todo.id !== todoId)
        })),
    completeTodo: (todoId) =>
        set((state) => ({
            todos: state.todos.map((todo) => {
                if(todo.id === todoId) {
                    return {
                        ...todo,
                        isCompleted: true
                    }
                }

                return todo;
            })
        }))
}))

let id = 0;
function getId() {
    return id++;
}