import { create } from "zustand"

const useStore = create(set => ({
    itemdata: [{}],
    setItemdata: (newitemdata) => set({ itemdata: newitemdata })

}))

export default useStore