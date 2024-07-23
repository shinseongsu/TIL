import Link from 'next/link';
import {Metadata} from "next";

export const metadata: Metadata = {
  title: 'Nextjs. Tutorial',
  description: 'Next.js 튜토리얼 배우기'
}

export default function Home() {
  return <main>
    <Link href="/dashboard">Dashboard</Link>
  </main>;
}
