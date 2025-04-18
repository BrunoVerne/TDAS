public class Main {
    public static void main(String[] args) {
        // Crear empleados
        Empleado juan = new Empleado("Juan Pérez", 20345678901L, 400_000);
        Empleado maria = new Empleado("María Gómez", 27345678901L, 500_000);
        Empleado lucas = new Empleado("Lucas Díaz", 25345678901L, 450_000);

        // Crear proyecto con un empleado
        Proyecto proyectoA = new Proyecto("Sistema de Ventas", juan, 15);
        Proyecto proyectoB = new Proyecto("App Móvil", maria, 20);

        // Crear empresa con un proyecto
        Empresa empresa = new Empresa(proyectoA);
        empresa.agregarProyecto(proyectoB);

        // Asignar empleados
        empresa.asignarEmpleado(maria, proyectoA);
        empresa.asignarEmpleado(lucas, proyectoB);

        // Mostrar estado de proyectos
        System.out.println("=== ESTADO INICIAL ===");
        empresa.estadoProyectos();

        // Finalizar un proyecto
        System.out.println("\n=== FINALIZANDO PROYECTO A ===");
        // No podés llamar directamente a cambiarAFinalizado (es privado), entonces simulamos acceso
        // Si cambiás visibilidad, se puede llamar: empresa.finalizarProyecto(proyectoA);
        // Por ahora lo hacemos accediendo al método del proyecto directamente (esto es solo para pruebas):
        proyectoA.cambiarAFinalizado();

        // Mostrar estado actualizado
        System.out.println("\n=== ESTADO ACTUALIZADO ===");
        empresa.estadoProyectos();

        // Mostrar coste total de proyectos en curso
        System.out.println("\nCosto total de proyectos en curso: $" + empresa.costeProyectosActuales());
    }
}
