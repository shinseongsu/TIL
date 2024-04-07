import { create } from 'zustand';

const useUIState = create((set) => ({
    homeCategory: "",
    headerImageSrc: "https://images.unsplash.com/photo-1707833558984-3293e794031c",
    setHomeCategory: (category: string) => set({homeCategory: category}),
    setHeaderImageSrc: (src: string) => set({headerImageSrc: src}),
}));

export default useUIState;