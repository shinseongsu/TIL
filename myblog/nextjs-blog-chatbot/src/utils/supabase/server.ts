import { createServerClient } from '@supabase/ssr';
import { Database } from '@/types/supabase';

export const createClient = (
  cookies: Partial<{
    [key: string]: string;
  }>,
) => {
  return createServerClient<Database>(
    process.env.NEXT_PUBLIC_SUPABASE_URL!,
    process.env.NEXT_PUBLIC_SUPABASE_ANON_KEY!,
    {
      cookies: {
        get(name: string) {
          return cookies[name];
        },
      },
    },
  );
};
