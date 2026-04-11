import { Formik, Form } from "formik";
import * as Yup from "yup";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import FormInput from "../../components/forms/FormInput";

export default function CreateRestaurantPage() {
  const navigate = useNavigate();

  const initialValues = {
    name: "",
    city: "",
  };

  const validationSchema = Yup.object({
    name: Yup.string().required("Le nom est requis"),
    city: Yup.string().required("La ville est requise"),
  });

  const handleSubmit = async (values) => {
    try {
      await axios.post("/api/restaurants", values);
      navigate("/restaurants"); // retour à la liste
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div className="max-w-xl mx-auto p-6">
      <h1 className="text-xl font-bold mb-6">Créer un restaurant</h1>

      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={handleSubmit}
      >
        <Form className="bg-white shadow rounded p-6">
          <FormInput name="name" label="Nom du restaurant" />
          <FormInput name="city" label="Ville" />

          <div className="flex justify-end gap-2 mt-4">
            <button
              type="button"
              onClick={() => navigate("/restaurants")}
              className="px-4 py-2 border rounded"
            >
              Annuler
            </button>

            <button
              type="submit"
              className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
            >
              Enregistrer
            </button>
          </div>
        </Form>
      </Formik>
    </div>
  );
}