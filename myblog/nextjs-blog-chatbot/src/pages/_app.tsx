import '@/styles/globals.css';
import type { AppProps } from 'next/app';
import Header from '@/componentㄴ/Header';

export default function App({ Component, pageProps }: AppProps) {
  return (
    <div className="flex h-screen w-screen">
      <div className="flex flex-1 flex-col">
        <Header />
        <div className="overflow:y-auto flex flex-1 flex-col">
          <main>
            <Component {...pageProps} />
          </main>
        </div>
        {/* <Footer /> */}
      </div>
    </div>
  );
}
