import pandas as pd
import utilidades as util
import streamlit as st 
from PIL import Image

#pagina de presentacion o index
st.set_page_config(
    page_title="Info Liga Colombiana",
    initial_sidebar_state="expanded",
    layout="wide",
    page_icon="🏆"
)

#Lamamos la funcion de archivo utilidad
util.generarMenu()


#Estructura de presentación
left_col, center_col, right_col =st.columns([1,4,1],
                                    vertical_alignment="center")

#edito la columna central 
with center_col:
    st.title("Informe de la Liga Colombiana 2024-2")
    st.write("""
    En este espacio se puede mostrar cual es el desempeño de los equipos de futbol durante la liga Betplay
    En el año 2024 segundo semestre.

    En la pagina informes se puede observar los datos y su analisis""")
    
    imagen2 = Image.open("Media\\futbol.jpg")
    st.image(imagen2, use_container_width=True, width=500,
             caption="Seleccion Colombia")