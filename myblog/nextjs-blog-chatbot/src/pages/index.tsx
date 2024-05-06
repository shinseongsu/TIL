import Image from 'next/image';
import { Inter } from 'next/font/google';
import { cva, cn } from '@/utils/style';
import { GetServerSideProps } from 'next';
import { createClient } from '@/utils/supabase/server';
import { createClient as createBrowserClient } from '@/utils/supabase/client';

const inter = Inter({ subsets: ['latin'] });

export default function Home() {
  return (
    <main>
      <h1>NEXTJS HELLO WORLD</h1>
    </main>
  );
}
