import { NextResponse } from 'next/server';

export async function GET(request: Request) {
    return NextResponse.json({
        users: [
            { id: 1, name: "Alice" },
            { id: 2, name: "Bob" },
            { id: 3, name: "Charlie" }
        ]
    });
}