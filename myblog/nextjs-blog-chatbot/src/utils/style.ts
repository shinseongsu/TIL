import { cx } from 'class-variance-authority';
import { twMerge } from 'tailwind-merge';
import type { ClassValue } from 'class-variance-authority/types';

export * from 'class-variance-authority';

export type * from 'class-variance-authority';
export const cn = (...args: ClassValue[]) => twMerge(cx(args));
