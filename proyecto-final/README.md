# 🏥 Sistema de Gestión Hospitalaria

---

## 📌 - Identificar el problema del proyecto

Actualmente, el proceso de admisión y hospitalización presenta fallas importantes debido al uso de registros manuales y sistemas poco confiables. Esto genera errores en la información, retrasos en la atención y una mala experiencia para el paciente.

Además, no existe un control adecuado sobre la información clínica ni herramientas que permitan analizar datos para mejorar la gestión del hospital.

---

## 🧠 - Análisis del problema - Método Ishikawa
Se incorpora diagrama de causa-efecto el cual permite visualizar las principales causas del problema identificado.

<p align="center">
  <img src="images/Ishikawa.png" alt="Diagrama de Ishikawa" width="800"/>
</p> 

---

## 📚 - Documentación de antecedentes (Formato APA)

La digitalización en el sector salud ha demostrado ser fundamental para mejorar la eficiencia y reducir errores en los procesos hospitalarios. En este contexto, la gestión documental permite optimizar el acceso a la información, incrementar la seguridad de los datos y mejorar la productividad del personal (Kawak, 2023).

Asimismo, en el ámbito sanitario, el crecimiento de la documentación clínica ha generado la necesidad de implementar sistemas que garanticen el control de versiones, niveles de acceso y trazabilidad de la información (Ticportal, 2023).

Por otro lado, estudios recientes evidencian que aún persisten prácticas manuales en algunos centros de salud, lo que ralentiza la generación de reportes y dificulta el acceso oportuno a la información (Polo del Conocimiento, 2025).

**Referencias:**

**Kawak. (2023).** *Gestión documental para el sector salud, facilita tus procesos.*  
🔗 https://blog.kawak.net/es-mx/mejorando_sistemas_de_gestion_iso/gestion-documental-sector-salud  

**Ticportal. (2023).** *La elección de un sistema de gestión documental en el sector sanitario.*  
🔗 https://www.ticportal.es/temas/sistema-gestion-documental/gestion-documental-sectores/dms-sanitaria  

**Polo del Conocimiento. (2025).** *TIC para la gestión documental en el área de estadística del Hospital Rafael Ruiz del Cantón Pujilí.*  
🔗 https://polodelconocimiento.com/ojs/index.php/es/article/download/9865/pdf  

---

## ⚠️ - Identificar restricciones del proyecto

- ⏳ Tiempo limitado para el desarrollo del sistema  
- 💰 Presupuesto reducido  
- 🌐 Dependencia de la conectividad de red  
- 👥 Resistencia del personal al cambio  
- 🖥️ Infraestructura tecnológica limitada  

---

## 💡 - Proponer alternativas de solución

### 🔹 Alternativa 1: Mejorar el sistema actual  
Requiere menor inversión, pero no soluciona los problemas de fondo.

### 🔹 Alternativa 2: Implementar software externo  
Permite una implementación rápida, pero tiene alto costo y baja flexibilidad.

### ✅ Alternativa 3: Desarrollar un sistema propio (Elegida)  
Permite adaptar el sistema a las necesidades del hospital y escalarlo en el tiempo.

#### 📊 Sustento de la Alternativa Elegida
| Criterio | Alt 1: Mejora Sistema Actual | Alt 2: Software Externo (SaaS) | Alt 3: Desarrollo Propio |
| :--- | :--- | :--- | :--- |
| **Control de Datos** | Alto | Bajo (Terceros) | **Total (Soberanía)** |
| **Costo a largo plazo** | Bajo | Alto (Mensualidades) | **Bajo (Mantenimiento)** |
| **Personalización** | Nula | Limitada | **Total (A medida)** |

---

## 🎯 - Definir objetivos y alcance

### 🏁 Objetivo General  
Desarrollar un sistema de gestión hospitalaria que permita automatizar los procesos de admisión, atención médica y hospitalización, mejorando el control y la calidad del servicio.

### 📌 Objetivos Específicos
- Modelar la base de datos del sistema  
- Automatizar el registro de pacientes  
- Gestionar citas y hospitalización  
- Generar reportes y estadísticas  
- Mejorar la calidad del servicio  

---

## ⚙️ - Elaborar requerimientos funcionales y no funcionales

### 🔧 Requerimientos Funcionales (RF)

- RF1: El sistema permitirá registrar pacientes con información completa y validada.  
- RF2: El sistema permitirá actualizar los datos personales del paciente.
- RF3: El sistema permitirá eliminar registros de pacientes bajo condiciones controladas.  
- RF4: El sistema permitirá realizar búsquedas de pacientes mediante DNI u otros criterios.
- RF5: El sistema permitirá registrar médicos en la plataforma.  
- RF6: El sistema permitirá asignar especialidades a cada médico.  
- RF7: El sistema permitirá crear historias clínicas por paciente.
- RF8: El sistema permitirá actualizar la información de la historia clínica.  
- RF9: El sistema permitirá agendar citas médicas.  
- RF10: El sistema permitirá reprogramar citas existentes.  
- RF11: El sistema permitirá cancelar citas registradas.  
- RF12: El sistema permitirá registrar procesos de hospitalización.  
- RF13: El sistema permitirá asignar camas disponibles a pacientes.  
- RF14: El sistema permitirá transferir pacientes entre áreas o servicios.  
- RF15: El sistema permitirá registrar el alta médica del paciente.  
- RF16: El sistema permitirá generar reportes operativos.  
- RF17: El sistema permitirá exportar o imprimir listados.  
- RF18: El sistema permitirá administrar usuarios del sistema.  
- RF19: El sistema permitirá autenticación mediante inicio de sesión seguro.  
- RF20: El sistema permitirá cambiar la contraseña de usuario.  
- RF21: El sistema permitirá registrar actividades para auditoría.  
- RF22: El sistema permitirá gestionar roles y permisos.  
- RF23: El sistema permitirá exportar información en diferentes formatos.  
- RF24: El sistema permitirá importar datos al sistema.  
- RF25: El sistema permitirá enviar notificaciones a usuarios.  
- RF26: El sistema permitirá generar alertas médicas relevantes.  
- RF27: El sistema permitirá consultar el historial completo del paciente.  
- RF28: El sistema mostrará un panel (dashboard) con información resumida.  
- RF29: El sistema permitirá visualizar estadísticas del sistema.  
- RF30: El sistema realizará gestionar el estado de las citas médicas
- RF31: El sistema permitirá restaurar información desde backups.  
- RF32: El sistema permitirá gestionar sesiones activas de usuarios.  
- RF33: El sistema permitirá registrar diagnósticos asociados a cada historia clínica del paciente.
- RF34: El sistema validará los datos ingresados por el usuario.  
- RF35: El sistema manejará errores de forma controlada.  
- RF36: El sistema permitirá validar la disponibilidad de médicos.
- RF37: El sistema permitirá accesos rápidos a funciones frecuentes.  
- RF38: El sistema permitirá aplicar filtros avanzados en consultas.  
- RF39: El sistema permitirá ordenar la información mostrada.  
- RF40: El sistema permitirá registrar la fecha y hora de inicio y fin de cada atención médica.  

---

### 🛡️ Requerimientos No Funcionales (RNF)

RNF1: Seguridad: Implementación de **RBAC** (Control de Acceso Basado en Roles) y cumplimiento con la **Ley N° 29733** de Protección de Datos Personales.  
RNF2: Integridad: Se garantizará la consistencia de los datos.  
RNF3: Usabilidad: Interfaz intuitiva con operaciones rápidas.  
RNF4: Disponibilidad: El sistema debe garantizar un **99.5% de tiempo de actividad** (Uptime) durante el horario operativo del hospital.  
RNF5: Rendimiento: El tiempo de respuesta para consultas de búsqueda de pacientes no debe exceder los **2 segundos**.  
RNF6: Escalabilidad: Poder complementar con sistemas de terceros y mejor la interconectividad.

---

## 👤 - Redactar historias de usuario

- **HU1:** Como usuario, quiero iniciar sesión con mi usuario y contraseña, para acceder de forma segura al sistema.  

  **Criterios de aceptación:**  
  - El sistema deberá solicitar usuario y contraseña obligatoriamente.  
  - Solo se permitirá el acceso con credenciales válidas.  
  - El sistema deberá mostrar un mensaje si los datos ingresados son incorrectos.  
  - Al iniciar sesión correctamente, el sistema mostrará el menú principal.  

- **HU2:** Como administrador, quiero gestionar usuarios para garantizar la seguridad.  

  **Criterios de aceptación:**  
  - El administrador deberá poder registrar nuevos usuarios.  
  - El sistema deberá permitir asignar roles.  
  - El administrador podrá desactivar usuarios existentes.  

- **HU3:** Como usuario, quiero cambiar mi contraseña para proteger mi acceso.  

  **Criterios de aceptación:**  
  - El usuario deberá ingresar su contraseña actual.  
  - La nueva contraseña deberá guardarse correctamente.  
  - El sistema mostrará confirmación del cambio realizado.  

- **HU4:** Como personal administrativo, quiero que el sistema valide el DNI, los campos obligatorios y el correo electrónico del paciente, para evitar registros incorrectos y permitir el envío de notificaciones importantes.  

  **Criterios de aceptación:**  
  - El sistema deberá solicitar nombre, DNI, edad y correo electrónico de forma obligatoria.  
  - No se permitirá registrar pacientes con DNI repetido.  
  - El correo electrónico deberá tener un formato válido.  
  - El sistema mostrará un mensaje confirmando el registro exitoso.  
  - El sistema deberá guardar el correo electrónico para futuras notificaciones.  

- **HU5:** Como personal administrativo, quiero buscar pacientes por DNI o nombre, para agilizar la atención y evitar registros duplicados.  

  **Criterios de aceptación:**  
  - El sistema deberá permitir búsquedas por DNI.  
  - El sistema deberá permitir búsquedas por nombre.  
  - Si no existe el paciente, deberá mostrarse un mensaje informativo.  

- **HU6:** Como administrador, quiero asignar una especialidad al perfil del médico, para organizar correctamente la atención médica.  

  **Criterios de aceptación:**  
  - El sistema deberá permitir seleccionar una especialidad.  
  - La especialidad deberá quedar registrada en el perfil del médico.  
  - El médico podrá visualizar su especialidad asignada.  

- **HU7:** Como personal administrativo, quiero agendar, reprogramar o cancelar citas médicas, para organizar la atención de los pacientes.  

  **Criterios de aceptación:**  
  - El sistema deberá permitir registrar una cita con fecha y médico.  
  - El usuario podrá modificar la fecha de una cita existente.  
  - El sistema deberá permitir cancelar citas registradas.  

- **HU8:** Como médico, quiero acceder al historial clínico del paciente, para mejorar el diagnóstico.  

  **Criterios de aceptación:**  
  - El médico deberá poder seleccionar un paciente registrado.  
  - El sistema deberá mostrar el historial clínico registrado.  
  - Solo usuarios autorizados podrán acceder a esta información.  

- **HU9:** Como médico, quiero registrar la fecha y hora exacta de inicio y fin de cada atención, para medir los tiempos de espera y mejorar la eficiencia del servicio.  

  **Criterios de aceptación:**  
  - El sistema deberá permitir registrar la hora de inicio y fin de atención.  
  - La información deberá guardarse correctamente.  
  - El sistema deberá mostrar la duración total de la atención.  

- **HU10:** Como médico, quiero registrar el alta médica del paciente, para que el sistema genere automáticamente el resumen de salida y libere los recursos.  

  **Criterios de aceptación:**  
  - El médico deberá poder registrar el alta médica del paciente.  
  - El sistema deberá actualizar el estado del paciente.  
  - El sistema deberá guardar la fecha y el diagnóstico final del paciente.  
  - El sistema deberá generar un resumen básico de salida.  

- **HU11:** Como paciente, quiero recibir notificaciones en mi correo electrónico sobre mis citas médicas, para estar informado de mis registros, cambios o cancelaciones realizadas.  

  **Criterios de aceptación:**  
  - El sistema deberá utilizar el correo electrónico registrado del paciente.  
  - El sistema deberá enviar una notificación al registrar una nueva cita.  
  - El sistema deberá enviar una notificación cuando una cita sea reprogramada o cancelada.  
  - El sistema deberá mostrar un mensaje confirmando el envío de la notificación.  

---

## 📈 - Indicadores de Éxito
| Indicador | Meta |
| :--- | :--- |
| ⏳ **Reducción del tiempo de admisión** | 40% menos respecto al proceso manual |
| 📝 **Disminución de errores en registros clínicos** | 60% menos gracias a validaciones automáticas |
| 😀 **Incremento en la satisfacción del paciente** | 30% más, medido mediante encuestas internas |
| 📊 **Generación de reportes** | Menos de 1 minuto por reporte |
| 🌐 **Disponibilidad del sistema** | Superior al 99.5% |
| 🔒 **Cumplimiento normativo en protección de datos** | Total cumplimiento con Ley N° 29733 |

---

## 🧩 - Plan de Implementación
| Fase | Actividades |
| :--- | :--- |
| 📌 **Fase 1 – Análisis y Diseño** | Levantamiento de requerimientos, modelado de base de datos, definición de arquitectura |
| 📌 **Fase 2 – Desarrollo** | Construcción de módulos principales (pacientes, médicos, citas, hospitalización), implementación de seguridad y roles |
| 📌 **Fase 3 – Pruebas Piloto** | Validación en un área del hospital, corrección de errores y ajustes |
| 📌 **Fase 4 – Capacitación** | Entrenamiento del personal administrativo y médico, elaboración de manuales y guías rápidas |
| 📌 **Fase 5 – Implementación Total** | Despliegue en todas las áreas del hospital, monitoreo inicial para asegurar estabilidad |
| 📌 **Fase 6 – Mantenimiento y Mejora Continua** | Actualizaciones periódicas, integración futura con telemedicina, laboratorios y aseguradoras |

---
