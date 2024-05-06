import { FC } from 'react';
import Link from 'next/link';
import { AiOutlineMenu } from 'react-icons/ai';
import { BsRobot } from 'react-icons/bs';

const Header: FC = () => {
  return (
    <header className="flex h-16 items-center justify-between border-b px-4 lg:h-20 lg:px-10">
      <button className="p-2">
        <AiOutlineMenu className="size-5 lg:size-6"></AiOutlineMenu>
      </button>
      <Link href="/">
        <h1 className="text-3xl font-medium text-slate-600 lg:text-4xl">
          BLOG
        </h1>
      </Link>
      <Link href="/posts" className="p-2">
        <BsRobot className="size-5 lg:size-6"></BsRobot>
      </Link>
    </header>
  );
};

export default Header;
