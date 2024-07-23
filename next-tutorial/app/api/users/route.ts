import { NextResponse } from 'next/server';

const DB = [
    { id: 1, name: "Alice" },
    { id: 2, name: "Bob" },
    { id: 3, name: "Charlie" }
]

export async function GET(request: Request) {
    const searchParams = new URL(request.url).searchParams;
    const name = searchParams.get('name');

    return NextResponse.json({
        users: DB.filter((user) => user.name.includes(name))
    });
}
