import {rest} from 'msw';

export const handlers = [
    rest.get('http://localhost:5000/products', (req, res, ctx) => {
        return res(
            ctx.json([{
                    name: "America",
                    imagePath: "/images/america.jpeg"
                },
                {
                    name: "England",
                    imagePath: "/images/england.jpeg"
                }
            ])
        )
    }),
    rest.get('http://localhost:5000/options', (req, res, ctx) => {
        return res(
            ctx.json([
                {
                    name: "Insurance",
                },
                {
                    name: "Dinner"
                }
            ])
        )
    })
]