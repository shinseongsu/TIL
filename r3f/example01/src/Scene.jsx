import { Canvas } from "@react-three/fiber";
import { Box } from "./Box";
import { Ground } from "./Ground";
import { Debug, Physics } from "@react-three/cannon";

function Scene() {
  return (
    <>
      <Canvas camera={{ position: [0, 2, 4] }}>
        <Physics gravity={[0, -9.81, 0]}>
          <Debug>
            <ambientLight />
            <directionalLight position={[0, 5, 5]} />
            <Box position={[0, 1, 0]} />
            <Ground rotation={[-Math.PI / 2, 0, 0]} />
          </Debug>
        </Physics>
      </Canvas>
    </>
  );
}

export default Scene;
