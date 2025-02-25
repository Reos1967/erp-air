import pandas as pd
import utilidades as util
import streamlit as st
from matplotlib import pyplot
import seaborn as sns

#configurar encabezado de pagina
st.set_page_config(
    page_title="Info de la Liga",
    initial_sidebar_state="expanded",
    layout="centered",
    page_icon="📝"
)

util.generarMenu()



#visualizacion 
st.title("Datos de la liga Colombiana 2024")
ruta = "Data/todosContraTodosClean.csv"
df = pd.read_csv(ruta)
tex ="Cantidad de Goles marcados por cada equipo"

util.tablaGoles(df, tex)
